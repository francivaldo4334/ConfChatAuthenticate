package br.com.confchat.auth.di

import android.app.Application
import android.content.Context
import br.com.confchat.auth.data.database.room.confchatauth.AuthenticationDb
import br.com.confchat.auth.data.database.room.userdb.UserDb
import br.com.confchat.auth.domain.repository.contract.IUserDomainRepository
import br.com.confchat.auth.domain.repository.implementation.UserDomainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryProviders {
    @Provides
    @Singleton
    fun getUserDomain( @ApplicationContext context:Context):IUserDomainRepository {
        return UserDomainRepository(AuthenticationDb.getInstance(context).getUserDao(),context)
    }
}