package br.com.confchat.auth.domain.repository.implementation

import br.com.confchat.auth.domain.repository.contract.ITotpDomainRepository
import java.nio.ByteBuffer
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class TotpDomainRepository : ITotpDomainRepository {
    private val HMAC_SHA1_ALGORITHM = "HmacSHA1"
    private val DIGITS = 6
    private val WINDOW = 30
    override fun generateCode(secret: String, counter: Long): String {
        val hmacKey = SecretKeySpec(secret.toByteArray(), HMAC_SHA1_ALGORITHM)
        val mac = Mac.getInstance(HMAC_SHA1_ALGORITHM)
        mac.init(hmacKey)

        val text = ByteBuffer.allocate(8).putLong(counter).array()
        val hash = mac.doFinal(text)

        val offset = hash[hash.size - 1].toInt() and 0xf
        val binary =
            (hash[offset].toInt() and 0x7f shl 24) or
                    (hash[offset + 1].toInt() and 0xff shl 16) or
                    (hash[offset + 2].toInt() and 0xff shl 8) or
                    (hash[offset + 3].toInt() and 0xff)

        val otp = binary % 1000000
        return "%0${DIGITS}d".format(otp)
    }
}