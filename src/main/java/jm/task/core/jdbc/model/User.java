package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity
 @Table(name="user")
/**
 * Аннотацией @Entity отмечаются классы, которые представляют собой сущности базы данных.
 * Например, если в базе данных есть таблица User, которая содержит список пользователей, в Java должен существовать класс User,
 * отмеченный аннотацией @Entity, объектом этого класса будет строка таблицы User. Часто используется совместно с аннотацией @Table,
 * которая помогает явно определить некоторую информацию о таблице.
 */
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Этот вид стратегии генерации первичного ключа обычно известен как саморазвитие первичного ключа.
     * Когда база данных вставляет данные, она автоматически присваивает значение первичному ключу.
     * Например, MYSQL может объявить «auto_increment» при создании таблицы, чтобы указать саморазвитие первичного ключа.
     * Эта стратегия обеспечивает поддержку в большинстве баз данных (указанные методы или ключевые слова могут отличаться),
     * но есть еще несколько баз данных, которые не поддерживают ее, поэтому переносимость немного ухудшена.
     * Чтобы использовать стратегию генерации первичного ключа для саморазвития, вам нужно только объявить policy = GenerationType.IDENTITY.
     *
     * Следует отметить, что в одной и той же таблице может быть не более одного столбца.
     */

    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;



    public User() {}

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "User { " + "id = " + id + ", name = " + '\'' + name + '\'' + ", lastName = " + '\'' + lastName + '\'' + ", age = " + age + '}';
    }
}



