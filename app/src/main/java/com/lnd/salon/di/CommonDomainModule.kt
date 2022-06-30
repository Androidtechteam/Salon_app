package com.lnd.salon.di

import com.lnd.salon.data.repository.CommonRepository
import com.lnd.salon.data.repository.CommonRepositoryImpl
import com.lnd.salon.domain.CommonUseCase
import com.lnd.salon.domain.CommonUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CommonDomainModule {
    @Binds
    abstract fun bindsUseCase(commonUseCaseImpl: CommonUseCaseImpl) : CommonUseCase

    @Binds
    abstract fun bindsRepository(commonRepositoryImpl: CommonRepositoryImpl) : CommonRepository
}