package com.designpattern.factory;

/**
 * 抽象工厂模式
 * 为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类
 *
 *
 * 工厂方法：多个工厂类，一个产品抽象类，利用多态创建不同的产品对象，避免了大量的if-else判断。
 * 抽象工厂：多个工厂类，多个产品抽象类，产品子类分组，同一个工厂实现类创建同组中的不同产品，减少了工厂子类的数量。
 */
interface IConnection {
    void connect();
}

// 变化: mysql, oracle ...
//      connection, command

interface ICommand {
    void command();
}

interface IDatabaseUtils {
    IConnection getConnection();

    ICommand getCommand();
}

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils databaseUtils = new MysqlDatabseUtils();
        IConnection connection = databaseUtils.getConnection();
        ICommand command = databaseUtils.getCommand();
        connection.connect();
        command.command();
    }
}

class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("mysql connected");
    }
}

class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MysqlDatabseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}


class OracleConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("oracle connected");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("oracle command");
    }
}

class OracleDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}