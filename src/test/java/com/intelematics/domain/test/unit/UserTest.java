package com.intelematics.domain.test.unit;

import com.intelematics.domain.user.User;
import org.hibernate.validator.HibernateValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by Ian on 3/2/2016.
 */
public class UserTest {
    private LocalValidatorFactoryBean localValidatorFactory;

    @BeforeMethod
    public void setup() {
        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
    }

    @Test
    public void testUser() {
        final User user = new User("test", "test", "test", "test");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 0);
    }

    @Test
    public void testUsernameNullValidationError() {
        final User user = new User(null, "test", "test", "test");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testPasswordNullValidationError() {
        final User user = new User("test", null, "test", "test");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testFirstNameNullValidationError() {
        final User user = new User("test", "test", null, "test");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testLastNameNullValidationError() {
        final User user = new User("test", "test", "test", null);
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }


    @Test
    public void testUsernameTooLongValidationError() {
        final User user = new User("kjsdhfkshd fjgsdjfsdjfgskhsdfkshdfkhsdfsdkhfksdjhfkjhsdkfhsdkjfhksdjhfksdjhfkjh", "test", "test", "test");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testPasswordTooLongValidationError() {
        final User user = new User("test", "kjsdhfkshd fjgsdjfsdjfgskhsdfkshdfkhsdfsdkhfksdjhfkjhsdkfhsdkjfhksdjhfksdjhfkjh", "test", "test");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testFirstNameTooLongValidationError() {
        final User user = new User("test", "test", "test", "test");
        user.setFirstName("kjsdhfkshd fjgsdjfsdjfgskhsdfkshdfkhsdfsdkhfksdjhfkjhsdkfhsdkjfhksdjsdfhskdjfhksdjhfksdhfkjhsdfhsdfsdhfsdhfjsdghjfgsdjkfhgsdjgfjksdghfjksdghfjgsdjkfhsdjkghfsdjghfsdjkghfjksdghfkjsdghfhfksdjhfkjh");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testLastNameTooLongValidationError() {
        final User user = new User("test", "test", "test", "test");
        user.setLastName("kjsdhfkshd fjgsdjfsdjfgskhsdfkshdfkhsdfsdkhfksdjhfkjhsdkfhsdkjfhksdjsdfhskdjfhksdjhfksdhfkjhsdfhsdfsdhfsdhfjsdghjfgsdjkfhgsdjgfjksdghfjksdghfjgsdjkfhsdjkghfsdjghfsdjkghfjksdghfkjsdghfhfksdjhfkjh");
        Set<ConstraintViolation<User>> constraintViolations = localValidatorFactory.validate(user);
        Assert.assertTrue(constraintViolations.size() == 1);
    }

}
