package lift.waibiwaibi.community.mapper;

import lift.waibiwaibi.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("Insert into user (name,account_id,token,gmt_create,gmt_modified) value (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

}
