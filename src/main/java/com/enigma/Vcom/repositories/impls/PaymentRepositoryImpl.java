package com.enigma.Vcom.repositories.impls;

import com.enigma.Vcom.entities.Payment;
import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.models.PaymentModel;
import com.enigma.Vcom.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SAVE_PAYMENT = "INSERT INTO payment" +
            " (amount, description, profile_id) VALUES(?,?,?)";
    private final String UPDATE_PAYMENT = "UPDATE payment SET " +
            "amount = ?, description = ?, profile_id = ? WHERE id = ?";
    private final String FINDBYID_PAYMENT = "SELECT * FROM payment py " +
            "LEFT JOIN profile p ON py.profile_id = p.id WHERE py.id = ?";
    private final String FINDALL_PAYMENT = "SELECT * FROM payment py LEFT JOIN profile p ON py.profile_id = p.id ";
    private final String DELETE_PAYMENT = "DELETE FROM payment WHERE id = ?";

    @Override
    public boolean save(PaymentModel payment) {
        return jdbcTemplate.update(SAVE_PAYMENT, payment.getAmount(),payment.getDescription(), payment.getProfileId()) > 0;
    }

    @Override
    public boolean update(PaymentModel payment) {
        return jdbcTemplate.update(UPDATE_PAYMENT, payment.getAmount(),payment.getDescription(),
                payment.getProfileId(), payment.getId()) > 0;
    }

    @Override
    public boolean delete(Payment payment) {

        return jdbcTemplate.update(DELETE_PAYMENT, payment.getId()) > 0;
    }

    @Override
    public Payment findById(Integer id) {
        List<Payment> paymentList = jdbcTemplate.query(FINDBYID_PAYMENT, new RowMapper<Payment>() {
            @Override
            public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
                Payment payment = new Payment();
                payment.setId(resultSet.getInt("id"));
                payment.setAmount(resultSet.getInt("amount"));
                payment.setDescription(resultSet.getString("description"));
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
                payment.setProfile(profile);

                return payment;
            }
        }, new Object[]{id});
        return paymentList.get(0);
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> paymentList = jdbcTemplate.query(FINDALL_PAYMENT, new RowMapper<Payment>() {
            @Override
            public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
                Payment payment = new Payment();
                payment.setId(resultSet.getInt("id"));
                payment.setAmount(resultSet.getInt("amount"));
                payment.setDescription(resultSet.getString("description"));
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
                payment.setProfile(profile);

                return payment;
            }
        });
        return paymentList;
    }
}
