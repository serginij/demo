import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/*
    Разработал: Сергей Котлицкий
    github: https://github.com/serginij
    email: kotlizkiy@gmail.com
*/

public class Licence {
    protected int id;
    protected String name, surname, fatherName, number;
    protected LocalDate birthday, expiredDate;

    // Пустой конструктор для дальнейшего использования сеттеров
    Licence() {
    }

    /* Конструктор, который принимает ResultSet.
       В поля класса записываются соответствующие значения из ResultSet
    */
    Licence(ResultSet data) {
        try {
            id = data.getInt("id");
            name = data.getString("name");
            surname = data.getString("surname");
            fatherName = data.getString("father_name");
            number = data.getString("number");
            birthday = LocalDate.parse(data.getString("birthday"));
            expiredDate = LocalDate.parse(data.getString("expired_date"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables);
            JOptionPane.showMessageDialog(null, "Произошла ошибка при обработке данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Функции - сеттеры
    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setSurname(String surname){this.surname = surname;}
    public void setFatherName(String fatherName){this.fatherName = fatherName;}
    public void setNumber(String number){this.number = number;}
    public void setBirthday(LocalDate birthday){this.birthday = birthday;}
    public void setExpiredDate(LocalDate expiredDate){this.expiredDate = expiredDate;}

    // Функции - геттеры
    public int getId(){return id;}
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getFatherName(){return fatherName;}
    public String getNumber(){return number;}
    public LocalDate getBirthday(){return birthday;}
    public LocalDate getExpiredDate(){return expiredDate;}

    // Функция для получения ФИО
    public String getFullName () {
        if(fatherName.equals("") || fatherName == null) {
            return surname + " " + name.charAt(0) + ".";
        } else return surname + " " + name.charAt(0) + ". " + fatherName.charAt(0) + ".";
    }
}
