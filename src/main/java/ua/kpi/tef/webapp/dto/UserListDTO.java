package ua.kpi.tef.webapp.dto;

import lombok.*;
import ua.kpi.tef.webapp.entity.User;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserListDTO {
	private List<User> users;
}
