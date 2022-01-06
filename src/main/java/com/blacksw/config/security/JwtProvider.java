package com.blacksw.config.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtProvider {

	@Value("spring.jwt.secret")
	private String secretKey;								// 시크릿 키
	private final long TOKEN_VALID_MILLI_SECOND = 60 * 60 * 1000L;	// 유효기간
	
	@Autowired
	private CustomUserDetailService userDetailService;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	// JWT 생성
	public String createToken(String userPk, List<String> roles) {
		
		// 현재 날짜 생성
		Date now = new Date();

		// 클레임 생성
		Claims claims = Jwts.claims().setSubject(userPk);
		claims.put("roles", roles);
		
		// 토큰 생성
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + TOKEN_VALID_MILLI_SECOND))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}

	// Authentication(=인증정보) 반환
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = userDetailService.loadUserByUsername(this.getUserPk(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	// UserPk 반환
	public String getUserPk(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	// HTTP Request Header에서 Token 파싱
	public String resolveToken(HttpServletRequest request) {
		return request.getHeader("X-AUTH-TOKEN");
	}
	
	// JWT 유효성 검증
	public boolean validationToken(String token) {
		try {
			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return claimsJws.getBody().getExpiration().before(new Date());
		} catch(Exception e) {
			return false;
		}
	}
	
}
