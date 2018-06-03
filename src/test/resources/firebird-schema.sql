EXECUTE BLOCK AS BEGIN
  IF (EXISTS(SELECT 1 FROM rdb$relations WHERE rdb$relation_name = 'inlist_test_table')) THEN
    EXECUTE STATEMENT 'DROP TABLE inlist_test_table;';
END!!

CREATE TABLE inlist_test_table (
  id  NUMERIC(5) NOT NULL PRIMARY KEY,
  val VARCHAR(50) NOT NULL
)!!
