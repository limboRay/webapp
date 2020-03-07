package ua.kpi.tef.webapp.dto;

import lombok.*;
import ua.kpi.tef.webapp.entity.User;

import java.util.List;

/**
 * Created by Anton Domin on 2020-03-05
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserListDTO {
	private List<User> users;
}
