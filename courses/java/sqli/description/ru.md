## Атака "SQL-injection"

Атака типа "Injection" позволяет атакующему внедрить произвольный код через приложение в другую систему (например, при выполнении внешних программ через shell или обращении к базам данных через SQL).

SQL-инъекции возникают, когда программа формирует запросы к базе данных динамически, включая в них данные, полученные из недоверенных источников.

### Защитные меры

Никакой пользовательский ввод не должен попадать в SQL запросы в сыром виде, лучше через ORM, если custom запросы необходимы для оптимизации — только строго приведенными к нужному типу, с использованием prepared statements:
```java
import org.springframework.jdbc.core.JdbcTemplate;

	@Autowired
    private JdbcTemplate jdbcTemplate;

	public Customer findByCustomerId(Long id) {

        String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerRowMapper());

    }
```

### Задание

Данный код содержит уязвимость SQL injection. Найди и исправь уязвимость, не меняя поведение программы.

### Дополнительная информация

* https://www.owasp.org/index.php/Top_10-2017_A1-Injection