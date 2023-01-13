package com.example.jiocin

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

class TokenGenerater {

    fun generateToken():String{
     return Jwts.builder().claim("SubID", "1234567890").claim("Expire", 2673242942)
         .signWith(SignatureAlgorithm.HS256, "JIOGAMESKEY".toByteArray()).setHeaderParam("typ","JWT")
         .compact()
    }
}