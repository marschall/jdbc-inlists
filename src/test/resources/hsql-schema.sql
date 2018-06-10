DROP TABLE IF EXISTS inlist_test_table;
CREATE TABLE inlist_test_table (
  -- https://stackoverflow.com/questions/50665451/hsqldb-any-array-function-not-working
  id  INTEGER NOT NULL PRIMARY KEY,
  val VARCHAR(50) NOT NULL
);
