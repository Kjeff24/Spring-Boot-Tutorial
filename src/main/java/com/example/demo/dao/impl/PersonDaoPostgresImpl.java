package com.example.demo.dao.impl;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Objects;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class PersonDaoPostgresImpl implements PersonDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDaoPostgresImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person (id, name) VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setObject(1, id, Types.OTHER);
            ps.setString(2, person.getName());
            return ps;
        }, keyHolder);

        UUID generatedUUID = UUID.fromString(Objects.requireNonNull(keyHolder.getKeys()).get("id").toString());

        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UUID id = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            UUID personId = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            return new Person(personId, name);
        }, id);
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
