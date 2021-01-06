package config;
public interface DBConfig {
	//Driver 패키지 클래스
	public static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
	//URL
	public static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//접속 ID
	public static final String DB_USER = "cronoss";
	//접속 비번
	public static final String DB_PASS = "123456";
}
