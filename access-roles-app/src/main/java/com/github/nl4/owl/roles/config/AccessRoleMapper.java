package com.github.nl4.owl.roles.config;

import com.github.nl4.owl.roles.api.AccessRoleDto;
import com.github.nl4.owl.roles.api.AccessRoleRequest;
import com.github.nl4.owl.roles.api.LocationDto;
import com.github.nl4.owl.roles.domain.AccessRole;
import com.github.nl4.owl.roles.domain.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AccessRoleMapper {

    AccessRoleDto toAccessRoleDto(AccessRole role);

    Set<AccessRoleDto> toAccessRoleDtoSet(Set<AccessRole> roles);

    @Mapping(source = "locationId", target = "location.id")
    AccessRole toAccessRole(AccessRoleRequest role);

    LocationDto toLocationDto(Location location);

    Location toLocation(LocationDto location);

    Set<LocationDto> toLocationDtoSet(Set<Location> roles);

}