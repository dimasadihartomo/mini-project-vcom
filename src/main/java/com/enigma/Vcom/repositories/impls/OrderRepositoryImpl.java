package com.enigma.Vcom.repositories.impls;

import com.enigma.Vcom.entities.Order;
import com.enigma.Vcom.entities.Product;
import com.enigma.Vcom.entities.Profile;
import com.enigma.Vcom.models.OrderModel;
import com.enigma.Vcom.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SAVE_ORDER = "INSERT INTO orders" +
            " (order_date, product_id, profile_id) VALUES(?,?,?)";
    private final String UPDATE_ORDER = "UPDATE orders SET " +
            "order_date = ?, product_id = ?, profile_id = ? WHERE id = ?";
    private final String FINDBYID_ORDER = "SELECT * FROM orders o " +
            "LEFT JOIN profile p ON o.profile_id = p.id" +
            " LEFT JOIN product pr ON o.product_id = pr.id WHERE o.id = ?";
    private final String FINDALL_ORDER = "SELECT * FROM orders o " +
            "LEFT JOIN profile p ON o.profile_id = p.id LEFT JOIN product pr ON o.product_id = pr.id";
    private final String DELETE_ORDER = "DELETE FROM orders WHERE id = ?";

    @Override
    public boolean save(OrderModel order) {
        return jdbcTemplate.update(SAVE_ORDER, order.getOrderDate(), order.getProductId(), order.getProfileId()) > 0;
    }

    @Override
    public boolean update(OrderModel order) {
        return jdbcTemplate.update(UPDATE_ORDER, order.getOrderDate(), order.getProductId(), order.getProfileId(), order.getId()) > 0;
    }

    @Override
    public boolean delete(Order order) {
        return jdbcTemplate.update(DELETE_ORDER, order.getId()) > 0;
    }

    @Override
    public Order findById(Integer id) {
        List<Order> orderList = jdbcTemplate.query(FINDBYID_ORDER, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
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
                order.setProfile(profile);
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setDeveloper(resultSet.getString("developer"));
                product.setGenre(resultSet.getString("genre"));
                product.setPrice(resultSet.getInt("price"));
                product.setReleaseDate(resultSet.getString("release_date"));
                product.setSupportedSystem(resultSet.getString("supported_system"));
                product.setTitle(resultSet.getString("title"));
                product.setTypes(resultSet.getString("types"));
                order.setProduct(product);

                return order;
            }
        }, new Object[]{id});
        return orderList.get(0);
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = jdbcTemplate.query(FINDALL_ORDER, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
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
                order.setProfile(profile);
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setDeveloper(resultSet.getString("developer"));
                product.setGenre(resultSet.getString("genre"));
                product.setPrice(resultSet.getInt("price"));
                product.setReleaseDate(resultSet.getString("release_date"));
                product.setSupportedSystem(resultSet.getString("supported_system"));
                product.setTitle(resultSet.getString("title"));
                product.setTypes(resultSet.getString("types"));
                order.setProduct(product);

                return order;
            }
        });
        return orderList;
    }
}
