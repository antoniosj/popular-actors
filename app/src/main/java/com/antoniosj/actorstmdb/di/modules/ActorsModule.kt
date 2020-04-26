package com.antoniosj.actorstmdb.di.modules

import com.antoniosj.actorstmdb.actordetail.viewmodel.ActorDetailViewModel
import com.antoniosj.actorstmdb.listactors.viewmodel.ListActorsViewModel
import com.antoniosj.actorstmdb.actordetail.model.ActorDetailResponse
import com.antoniosj.actorstmdb.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActorsModule {

    @Singleton
    @Provides
    fun provideListActorsViewModel(): ListActorsViewModel = ListActorsViewModel()

    @Singleton
    @Provides
    fun provideActorDetailViewModel(repository: Repository<ActorDetailResponse>): ActorDetailViewModel = ActorDetailViewModel(repository)

}