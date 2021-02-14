package com.enigma.Vcom.repositories.impls;

import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.entities.User;
import com.enigma.Vcom.models.ProfileModel;
import com.enigma.Vcom.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SAVE_PROFILE = "INSERT INTO profile" +
            "(birth_date, country, email, first_name, gender, last_name, mobile_number, status, " +
            "v_pocket, user_id) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_PROFILE = "UPDATE profile SET " +
            "birth_date = ?, country = ?, email = ?, first_name = ?, gender = ?, " +
            "last_name = ?, mobile_number = ?, status = ?, v_pocket = ?, user_id = ? WHERE id = ?";
    private final String FINDBYID_PROFILE = "SELECT * FROM profile p " +
            "LEFT JOIN users u ON p.user_id = u.id WHERE p.id = ?";
    private final String FINDALL_PROFILE = "SELECT * FROM profile p LEFT JOIN users u ON p.user_id = u.id " +
            "WHERE status = true";
    private final String DELETE_PROFILE = "DELETE FROM profile WHERE id = ?";

    @Override
    public boolean save(ProfileModel profile) {
        return jdbcTemplate.update(SAVE_PROFILE, profile.getBirthDate(), profile.getCountry(), profile.getEmail(),
                profile.getFirstName(), profile.getGender(), profile.getLastName(), profile.getMobileNumber(),
                profile.getStatus(), profile.getvPocket(), profile.getUserId()) > 0;
    }

    @Override
    public boolean update(ProfileModel profile) {
        return jdbcTemplate.update(UPDATE_PROFILE, profile.getBirthDate(), profile.getCountry(), profile.getEmail(),
                profile.getFirstName(), profile.getGender(), profile.getLastName(), profile.getMobileNumber(),
                profile.getStatus(), profile.getvPocket(), profile.getUserId(), profile.getId()) > 0;
    }

    @Override
    public boolean delete(Profile profile) {
        return jdbcTemplate.update(DELETE_PROFILE, profile.getId()) > 0;
    }

    @Override
    public Profile findById(Integer id) {
        List<Profile> productList = jdbcTemplate.query(FINDBYID_PROFILE, new RowMapper<Profile>() {
            @Override
            public Profile mapRow(ResultSet resultSet, int i) throws SQLException {
                Profile profile = new Profile();
                profile.setId(resultSet.getInt("id"));
                profile.setBirthDate(resultSet.getString("birth_date"));
                profile.setCountry(resultSet.getString("country"));
                profile.setEmail(resultSet.getString("email"));
                profile.setFirstName(resultSet.getString("first_name"));
                profile.setGender(resultSet.getString("gender"));
                profile.setLastName(resultSet.getString("last_name"));
                profile.setMobileNumber(resultSet.getString("mobile_number"));
                profile.setvPocket(resultSet.getInt("v_pocket"));
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                profile.setUser(user);

                return profile;
            }
        }, new Object[]{id});
        return productList.get(0);
    }

    @Override
    public List<Profile> findAll() {
        List<Profile> productList = jdbcTemplate.query(FINDALL_PROFILE, new RowMapper<Profile>() {
            @Override
            public Profile mapRow(ResultSet resultSet, int i) throws SQLException {
                Profile profile = new Profile();
                profile.setId(resultSet.getInt("id"));
                profile.setBirthDate(resultSet.getString("birth_date"));
                profile.setCountry(resultSet.getString("country"));
                profile.setEmail(resultSet.getString("email"));
                profile.setFirstName(resultSet.getString("first_name"));
                profile.setGender(resultSet.getString("gender"));
                profile.setLastName(resultSet.getString("last_name"));
                profile.setMobileNumber(resultSet.getString("mobile_number"));
                profile.setvPocket(resultSet.getInt("v_pocket"));
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                profile.setUser(user);

                return profile;
            }
        });
        return productList;
    }
}
