package com.example.olympiad

import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ArmyBuilder {
    fun build(unitType: Set<String>, totalTroops: Int): Army {
        require(unitType.size <= totalTroops)

        var army = Army()
        var remainingTroops = totalTroops
        val unitTypesToGenerate = unitType.toMutableList()
        while (!unitTypesToGenerate.isEmpty()) {

            // If there's only one unit type remaining fill to capacity
            if (unitTypesToGenerate.size == 1) {
                val unitType = unitTypesToGenerate[0]
                army.addUnit(ArmyUnit(unitType, remainingTroops))
                unitTypesToGenerate.remove(unitType)
                break
            }

            // Otherwise, randomly select the unit type to allocate troops to first
            val unitTypeIdx = (0 until unitTypesToGenerate.size).random()
            val unitTypeName = unitTypesToGenerate[unitTypeIdx]

            // Ensure that there is at least 1 unit of each requested type
            val unitTypeCount = (1 until (remainingTroops - unitTypesToGenerate.size)).random()
            remainingTroops -= unitTypeCount

            army.addUnit(ArmyUnit(name = unitTypeName, troopCount = unitTypeCount))
            unitTypesToGenerate.removeAt(unitTypeIdx)
        }

        return army
    }
}

class Army {
    private var units = mutableListOf<ArmyUnit>()

    fun addUnit(unit: ArmyUnit) {
        units.add(unit)
    }

    fun getUnits(): List<ArmyUnit> {
        return units
    }
}

data class ArmyUnit(
    val name: String,
    val troopCount: Int
)

class ArmyBuilderTest {

    val builder = ArmyBuilder()

    @Test
    fun testValidArmyBuiltForSingleUnitType() {
        val army = builder.build(setOf("pikeman"), 100)
        val units = army.getUnits()

        assertEquals(1, units.size)
        assertEquals("pikeman", units[0].name)
        assertEquals(100, units[0].troopCount)
    }

    @Test
    fun testValidArmyBuildFor2UnitTypes() {
        val army = builder.build(setOf("t1", "t2"), 100)
        val units = army.getUnits()

        assertEquals(2, units.size)
        assertEquals(100, units[0].troopCount)
    }
}
