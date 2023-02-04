package com.beardness.yourchordsru.di.qualifiers

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainCoroutineScope

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoCoroutineScope