package ua.kpi.tef.webapp.dto;

import lombok.*;

/**
 * Created by Anton Domin on 2020-03-05
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
	private String email;
	private String password;
}