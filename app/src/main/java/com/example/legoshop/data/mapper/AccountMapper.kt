package com.example.legoshop.data.mapper

import com.example.legoshop.data.local.entities.account.AccountEntity
import com.example.legoshop.domain.model.Account

fun Account.toAccountEntity(): AccountEntity {
    return AccountEntity(
        username = username,
        email = email
    )
}