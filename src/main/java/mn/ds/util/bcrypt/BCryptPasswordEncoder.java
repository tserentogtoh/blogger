/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ds.util.bcrypt;

import java.security.SecureRandom;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author nhbt
 */
public class BCryptPasswordEncoder implements PasswordEncoder {

    static final int MIN_LOG_ROUNDS = 4;
    static final int MAX_LOG_ROUNDS = 31;

    private final Pattern BCRYPT_PATTERN = Pattern
            .compile("\\A\\$2y?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
    private final Log logger = LogFactory.getLog(getClass());

    private final int strength;

    private final SecureRandom random;

    public BCryptPasswordEncoder() {
        this(-1);
    }

    /**
     * @param strength the log rounds to use, between 4 and 31
     */
    public BCryptPasswordEncoder(int strength) {
        this(strength, null);
    }

    /**
     * @param strength the log rounds to use, between 4 and 31
     * @param random the secure random instance to use
     *
     */
    public BCryptPasswordEncoder(int strength, SecureRandom random) {
        if (strength != -1 && (strength < MIN_LOG_ROUNDS || strength > MAX_LOG_ROUNDS)) {
            throw new IllegalArgumentException("Bad strength");
        }
        this.strength = strength;
        this.random = random;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String salt;
        if (strength > 0) {
            if (random != null) {
                salt = BCrypt.gensalt(strength, random);
            } else {
                salt = BCrypt.gensalt(strength);
            }
        } else {
            salt = BCrypt.gensalt();
        }
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            logger.warn("Empty encoded password");
            return false;
        }

        if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
            logger.warn("Encoded password does not look like BCrypt");
            return false;
        }

        boolean checkpw = BCrypt.checkpw(rawPassword.toString(), encodedPassword);
        return checkpw;
    }
}
