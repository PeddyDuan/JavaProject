package main.java.serializable;

import java.io.Serializable;

/**
 * 人类vo
 *
 * @author Peddy
 * @time 2018-01-27 11:23
 */
class PersonVO implements Serializable{

    private static final long serialVersionUID = -9196308691438433783L;

    private String name;
    /**
     * 使用transient修饰（transient修饰的变量不参与序列化）
     */
    private transient String age;
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "name:" + name + "; age:" + age + "; address:" + address;
    }

}
