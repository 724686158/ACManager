package com.zzkun.service.extoj

import com.zzkun.model.ExtOjPbInfo
import com.zzkun.model.OJType
import com.zzkun.model.User
import com.zzkun.model.UserACPb
import com.zzkun.util.web.HDUWebGetter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by kun on 2016/10/15.
 */
@Service
open class HDUService : IExtOJAdapter {

    @Autowired lateinit var hduWebGetter : HDUWebGetter

    override fun getUserACPbsOnline(user: User): List<UserACPb> {
        val acPbs = hduWebGetter.userACPbs(user.hduName)
        return acPbs.map { UserACPb(user, OJType.HDU, it) } .toList()
    }

    override fun getAllPbInfoOnline(): List<ExtOjPbInfo> {
        return hduWebGetter.allPbInfo()
    }
}