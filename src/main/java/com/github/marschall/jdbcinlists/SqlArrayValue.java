package com.github.marschall.jdbcinlists;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.CleanupFailureDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.support.SqlValue;

public final class SqlArrayValue implements SqlValue {

  private final Object[] values;

  private final String typeName;

  private Array array;

  /**
   * Constructor that takes two parameters, one parameter with the array of values passed in to
   * the statement and one that takes the type name.
   * @param typeName the type name
   * @param values the array containing the values
   */
  public SqlArrayValue(String typeName, Object... values) {
    this.values = values;
    this.typeName = typeName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setValue(PreparedStatement ps, int paramIndex) throws SQLException {
    var array = this.createArray(ps.getConnection());
    ps.setArray(paramIndex, array);
  }

  private Array createArray(Connection conn) throws SQLException {
    if (this.array != null) {
      throw new InvalidDataAccessApiUsageException("Value bound more than once");
    }
    this.array = conn.createArrayOf(this.typeName, this.values);
    return this.array;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cleanup() {
    if (this.array == null) {
      // #cleanup may be called twice in case of exceptions
      // avoid calling #free twice
      return;
    }
    // https://docs.oracle.com/javase/tutorial/jdbc/basics/array.html#releasing_array
    try {
      this.array.free();
      this.array = null;
    } catch (SQLException e) {
      throw new CleanupFailureDataAccessException("could not free array", e);
    }
  }

}
