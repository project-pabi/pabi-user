package com.pabi.pabiuser.domain.Address;


import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class NotNullAddressValidator implements ConstraintValidator<NotNullAddress, Address> {

    private final Validator validator;


    public NotNullAddressValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * OrderNewBook 커스텀 벨리데이터<br/> OrderNewBook.doNotBuy 가 false 라면<br/> NewBookOrderQuantity 그룹의 제약
     * 검사
     *
     * @see Address
     * @see AddressGroup
     */
    @Override
    public boolean isValid(Address value, ConstraintValidatorContext context) {

        if (StringUtils.isNotBlank(value.getAddress()) || StringUtils.isNotBlank(
            value.getAddressEtc()) || StringUtils.isNotBlank(value.getZipcode())) {
            final Set<ConstraintViolation<Object>> constraintViolations = validator.validate(value,
                AddressGroup.class);
            if (CollectionUtils.isNotEmpty(constraintViolations)) {
                context.disableDefaultConstraintViolation();
                constraintViolations
                    .forEach(constraintViolation -> {
                        context.buildConstraintViolationWithTemplate(
                                constraintViolation.getMessageTemplate())
                            .addPropertyNode(constraintViolation.getPropertyPath().toString())
                            .addConstraintViolation();
                    });
                return false;
            }
        }

        return true;
    }
}