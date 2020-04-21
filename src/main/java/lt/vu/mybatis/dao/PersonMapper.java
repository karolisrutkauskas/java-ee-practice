package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Person;

import java.util.List;

public interface PersonMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Person
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Person
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    int insert(Person record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Person
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    Person selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Person
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    List<Person> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Person
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    int updateByPrimaryKey(Person record);
}