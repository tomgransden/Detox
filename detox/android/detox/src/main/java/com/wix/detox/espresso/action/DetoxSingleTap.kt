package com.wix.detox.espresso.action

import com.wix.detox.common.proxy.MethodCallJournal

open class DetoxSingleTap(uiControllerCallJournal: MethodCallJournal) : DetoxMultiTap(1, uiControllerCallJournal = uiControllerCallJournal)
