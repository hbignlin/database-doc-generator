package cn.enilu.tool.database.doc.generator;

import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.print("choose database:\n1:MySQL\n2:Oracle\n3:PostgreSQL\n4:SQLServer\n" +
            "Select the appropriate numbers choose database type\n" +
            "(Enter 'c' to cancel):\n ");
        String dbType = sc.nextLine();
        if ("c".equals(dbType)) {
            System.exit(-1);
        }
        if (Integer.valueOf(dbType) < 1 || Integer.valueOf(dbType) > 4) {
            System.out.println("wrong number,will exit");
            System.exit(-1);
        }
        String serviceName = null;
        if ("2".equals(dbType)) {
            System.out.println("input service name:");
            serviceName = sc.nextLine();
        }
        String dbName = null;
        if ("1".equals(dbType) || "3".equals(dbType) || "4".equals(dbType)) {
            System.out.println("input database name:");
            dbName = sc.nextLine();
        }
        System.out.println("input host (default 127.0.0.1) :");
        String ip = sc.nextLine();
        if ("".equals(ip)) {
            ip = "127.0.0.1";
        }

        System.out.println("input port (default " + getDefaultPort(dbType) + ") :");
        String port = sc.nextLine();
        if ("".equals(port)) {
            port = getDefaultPort(dbType);
        }

        System.out.println("input username (default " + getDefaultUser(dbType) + ") :");
        String username = sc.nextLine();
        if ("".equals(username)) {
            username = getDefaultUser(dbType);
        }

        System.out.println("input password (default 123456) :");
        String passowrd = sc.nextLine();
        if ("".equals(passowrd)) {
            passowrd = "123456";
        }

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
