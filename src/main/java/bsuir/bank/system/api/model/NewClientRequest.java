package bsuir.bank.system.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewClientRequest {

    private Long id;
    private Long pspId;

    @NotBlank(message = "Имя не должно быть пустой строкой")
    @Pattern(regexp = "[А-Я|а-я|A-Z|a-z]+", message = "Может содержать только символы русского алфавита и латинского")
    private String firstName;

    @NotBlank(message = "Фамилия не должна быть пустой строкой")
    @Pattern(regexp = "[А-Я|а-я|A-Z|a-z]+", message = "Может содержать только символы русского алфавита и латинского")
    private String lastName;

    @NotBlank(message = "Отчество не должно быть пустой строкой")
    @Pattern(regexp = "[А-Я|а-я|A-Z|a-z]+", message = "Может содержать только символы русского алфавита и латинского")
    private String middleName;

    @Past(message = "Дата дня рождения должна быть в прошлом")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull(message = "Пол обязательное поле")
    private Character gender;

    @NotBlank(message = "Серия паспорта не должна быть пустой строкой")
    private String pspSeries;

    @NotBlank(message = "Номер паспорта не должна быть пустой строкой")
    @Pattern(regexp = "[0-9]{7}", message = "Номер паспорта должен состоять из 7 цифр")
    private String pspNumber;

    @Past(message = "Дата выдачи паспорта должна быть в прошлом")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pspIssuedDate;

    @NotBlank(message = "Орган выдачи паспорта обязательное поле")
    private String pspIssuedBy;

    @NotBlank(message = "Идентификационный номер паспорта не должен быть пустой строкой")
    @Pattern(regexp = "[0-9]{7}[ABCKEMH][0-9]{3}(GB|PB|BA|BI)[0-9]",
            message = "Строка не соответствует формату идентификационного номера паспорта РБ")
    private String pspIdNumber;

    @NotBlank(message = "Место рождения не может быть пустой строкой")
    private String birthPlace;

    private Long registrationCityId;

    @Pattern(regexp = "\\+[0-9]{12}|^$", message = "Мобильный номер должен быть указан в международном формате")
    private String mobilePhone;

    @Pattern(regexp = "[0-9]{11}|^$", message = "Номер должен быть указан вместе с кодом города(региона)")
    private String homeNumber;

    private String email;

    private Long maritalStatusId;

    private Long disabilityId;

    @Positive(message = "Отрицательное значение недопустимо")
    private BigDecimal monthlySalary;

    private Boolean isPensioner;

    @NotBlank(message = "Фактический адрес проживания не может быть пустой строкой")
    private String factAddress;

    private Long factCityId;

    private Long citizenshipId;

}
