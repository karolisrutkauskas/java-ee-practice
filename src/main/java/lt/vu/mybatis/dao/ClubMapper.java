package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Club;

import java.util.List;

public interface ClubMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Club
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Club
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    int insert(Club record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Club
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    Club selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Club
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    List<Club> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Club
     *
     * @mbg.generated Sat Apr 18 16:30:40 EEST 2020
     */
    int updateByPrimaryKey(Club record);

    List<Club> selectByVenue(Integer venueId);
    Club updateVenue(Integer venueId, Integer clubId);
}