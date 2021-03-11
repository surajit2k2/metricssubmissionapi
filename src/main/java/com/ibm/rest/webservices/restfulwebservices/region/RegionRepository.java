package com.ibm.rest.webservices.restfulwebservices.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{
	@Query("select c from Region c join fetch c.subGroup where c.regionName = :regionName")
	Region findByRegionName(@Param("regionName") String regionName);
	
}
