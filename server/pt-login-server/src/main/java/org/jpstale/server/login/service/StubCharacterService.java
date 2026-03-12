package org.jpstale.server.login.service;

import org.jpstale.server.login.api.CharacterServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 占位实现：选角/删角一律返回 true。
 * TODO: 与 C++ 一致实现，CheckCharacterAccountGouvernance、SQLUpdateGMLevel、SQLDeleteCharacter。
 */
@Service
public class StubCharacterService implements CharacterServiceApi {

    private static final Logger log = LoggerFactory.getLogger(StubCharacterService.class);

    @Override
    public boolean selectCharacter(String accountName, String charName) {
        log.debug("Stub selectCharacter: account={}, char={}", accountName, charName);
        return true;
    }

    @Override
    public boolean deleteCharacter(String accountName, String charName) {
        log.debug("Stub deleteCharacter: account={}, char={}", accountName, charName);
        return true;
    }
}
