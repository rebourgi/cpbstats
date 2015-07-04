package fr.cpbstats.api.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * The {@link ServicesRequestMatcher} class.
 * 
 * @author rebourgi
 * 
 */
public class ServicesRequestMatcher implements RequestMatcher {

    /** {@inheritDoc} */
    @Override
    public boolean matches(final HttpServletRequest request) {
        String url = UrlUtils.buildRequestUrl(request);
        return StringUtils.startsWith(url, "/rest/");
    }

}
