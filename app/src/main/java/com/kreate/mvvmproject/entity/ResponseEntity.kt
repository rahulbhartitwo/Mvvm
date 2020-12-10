package com.kreate.mvvmproject.entity

data class ResponseEntity(
    val message: String,
    val type: String,
    val value: List<Value>
)

data class Value(
    val attributes: Attributes,
    val geometry: Geometry
)

data class Attributes(
    val Criteria: String,
    val Declared_Date: Long,
    val Last_Inspection_date: String,
    val MaLongenance_Base: String,
    val Monitoring_Frequency: String,
    val OBJECTID: Long,
    val Pipele_Size__in_inches__: Long,
    val Pipeline_Code: Long,
    val Pipeline_Name: String,
    val Region: String,
    val Remarks: String,
    val Removal_date: String,
    val Review_Frequency: String,
    val Section_Chainage_in_mts_: Long,
    val Section_Code: Long,
    val Section_Name: String,
    val Unique_ID__SectionCode_StartSec: String,
    val Vulnarable_Location_Details: String,
    val description: String,
    val endSectionChainage__in_mts_: Long,
    val startSectionChainage__in_mts_: Long,
    val type: String
)

data class Geometry(
    val paths: List<List<List<Double>>>
)