package ru.kototeam.locations_service.Locations;

import lombok.*;
import ru.kototeam.locations_service.Locations.dto.LocationsModelDtoGet;
import ru.kototeam.locations_service.Locations.dto.LocationsModelDtoPost;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationsModel {
	@Id
	private String name;
	
	public static LocationsModel fromDtoPost(LocationsModelDtoPost post) {
		return new LocationsModel(post.name());
	}
	public static LocationsModelDtoGet toDtoGet(LocationsModel loc) {
		return new LocationsModelDtoGet(loc.getName());
	}
}
