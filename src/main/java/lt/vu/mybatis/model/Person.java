package lt.vu.mybatis.model;

public class Person {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.Person.id
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.Person.first_name
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    private String firstName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.Person.last_name
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.Person.email
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    private String email;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.Person.id
     *
     * @return the value of dbo.Person.id
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.Person.id
     *
     * @param id the value for dbo.Person.id
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.Person.first_name
     *
     * @return the value of dbo.Person.first_name
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.Person.first_name
     *
     * @param firstName the value for dbo.Person.first_name
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.Person.last_name
     *
     * @return the value of dbo.Person.last_name
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.Person.last_name
     *
     * @param lastName the value for dbo.Person.last_name
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.Person.email
     *
     * @return the value of dbo.Person.email
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.Person.email
     *
     * @param email the value for dbo.Person.email
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    public void setEmail(String email) {
        this.email = email;
    }
}