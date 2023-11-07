package com.bsac.buro.repository

import com.bsac.buro.model.Constructor
import org.springframework.data.jpa.repository.JpaRepository

interface ConstructorRepository : JpaRepository<Constructor, Long> {
}