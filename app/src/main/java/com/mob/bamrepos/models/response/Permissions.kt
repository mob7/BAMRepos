package com.mob.bamrepos.models.response

data class Permissions(
    val admin: Boolean?,
    val push: Boolean?,
    val pull: Boolean?
)