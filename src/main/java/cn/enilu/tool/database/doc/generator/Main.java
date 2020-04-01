package cn.enilu.tool.database.doc.generator;

import cn.enilu.tool.database.doc.generator.database.Generator;
import cn.enilu.tool.database.doc.generator.database.MySQL;
import org.nutz.dao.impl.SimpleDataSource;

/**
 * Main
 *
 * @author zt
 * @version 2018/10/6 0006
 */
public class Main {
    public static void main(String[] args) {
        SimpleDataSource dataSource = new SimpleDataSource();
        String ip = "xxx";
        String dbName = "gateway_3.1";
        String port = "3306";
        String username = "xxx";
        dataSource.setJdbcUrl("jdbc:mysql://" + ip + ":" + port + "/" + dbName + "?useSSL=false");
        dataSource.setUsername(username);
        dataSource.setPassword("xxx");
        Generator generator = new MySQL(dbName, dataSource);
        generator.generateDoc();
    }
}
