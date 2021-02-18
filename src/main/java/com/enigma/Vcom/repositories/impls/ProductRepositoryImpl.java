package com.enigma.Vcom.repositories.impls;

import com.enigma.Vcom.entities.Product;
import com.enigma.Vcom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SAVE_PRODUCT = "INSERT INTO product" +
            "(developer, genre, price, release_date, status, supported_system, title, types) " +
            "VALUES(?,?,?,?,?,?,?,?)";
    private final String UPDATE_PRODUCT = "UPDATE product SET " +
            "developer = ?, genre = ?, price = ?, release_date = ?, status = ?, " +
            "supported_system = ?, title = ?, types = ? WHERE id = ?";
    private final String FINDBYID_PRODUCT = "SELECT * FROM product WHERE id = ?";
    private final String FINDALL_PRODUCT = "SELECT * FROM product WHERE status = true";
    private final String FINDALL_PRODUCTBYPRICE = "SELECT * FROM product WHERE price >= ? AND price <= ?";
    private final String FINDALL_PRODUCTBYTITLE = "SELECT * FROM product WHERE title LIKE ?";
    private final String FINDALL_PRODUCTBYTYPE = "SELECT * FROM product WHERE types LIKE ? ";

    @Override
    public boolean save(Product product) {
        return jdbcTemplate.update(SAVE_PRODUCT, product.getDeveloper(), product.getGenre(), product.getPrice(),
                product.getReleaseDate(), product.getStatus()
                , product.getSupportedSystem(), product.getTitle(), product.getTypes()) > 0;
    }

    @Override
    public boolean update(Product product) {
        return jdbcTemplate.update(UPDATE_PRODUCT, product.getDeveloper(), product.getGenre(), product.getPrice(),
                product.getReleaseDate(), product.getStatus()
                , product.getSupportedSystem(), product.getTitle(), product.getTypes(), product.getId()) > 0;
    }

    @Override
    public Product findById(Integer id) {
        List<Product> productList = jdbcTemplate.query(FINDBYID_PRODUCT, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setDeveloper(resultSet.getString("developer"));
                product.setGenre(resultSet.getString("genre"));
                product.setPrice(resultSet.getInt("price"));
                product.setReleaseDate(resultSet.getString("release_date"));
                product.setSupportedSystem(resultSet.getString("supported_system"));
                product.setTitle(resultSet.getString("title"));
                product.setTypes(resultSet.getString("types"));
                return product;
            }
        }, new Object[]{id});
        return productList.get(0);
    }

    @Override
    public List<Product> findAllbyTitle(String title) {
        List<Product> productList = jdbcTemplate.query(FINDALL_PRODUCTBYTITLE, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setDeveloper(resultSet.getString("developer"));
                product.setGenre(resultSet.getString("genre"));
                product.setPrice(resultSet.getInt("price"));
                product.setReleaseDate(resultSet.getString("release_date"));
                product.setSupportedSystem(resultSet.getString("supported_system"));
                product.setTitle(resultSet.getString("title"));
                product.setTypes(resultSet.getString("types"));
                return product;
            }
        }, title);
        return productList;
    }

    @Override
    public List<Product> findAllbyType(String type) {
        List<Product> productList = jdbcTemplate.query(FINDALL_PRODUCTBYTYPE, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setDeveloper(resultSet.getString("developer"));
                product.setGenre(resultSet.getString("genre"));
                product.setPrice(resultSet.getInt("price"));
                product.setReleaseDate(resultSet.getString("release_date"));
                product.setSupportedSystem(resultSet.getString("supported_system"));
                product.setTitle(resultSet.getString("title"));
                product.setTypes(resultSet.getString("types"));
                return product;
            }
        }, type);
        return productList;
    }

    @Override
    public List<Product> findAllbyPrice(Integer min, Integer max) {
        List<Product> productList = jdbcTemplate.query(FINDALL_PRODUCTBYPRICE, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setDeveloper(resultSet.getString("developer"));
                product.setGenre(resultSet.getString("genre"));
                product.setPrice(resultSet.getInt("price"));
                product.setReleaseDate(resultSet.getString("release_date"));
                product.setSupportedSystem(resultSet.getString("supported_system"));
                product.setTitle(resultSet.getString("title"));
                product.setTypes(resultSet.getString("types"));
                return product;
            }
        }, min, max);
        return productList;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = jdbcTemplate.query(FINDALL_PRODUCT, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setDeveloper(resultSet.getString("developer"));
                product.setGenre(resultSet.getString("genre"));
                product.setPrice(resultSet.getInt("price"));
                product.setReleaseDate(resultSet.getString("release_date"));
                product.setSupportedSystem(resultSet.getString("supported_system"));
                product.setTitle(resultSet.getString("title"));
                product.setTypes(resultSet.getString("types"));
                return product;
            }
        });
        return productList;
    }
}
