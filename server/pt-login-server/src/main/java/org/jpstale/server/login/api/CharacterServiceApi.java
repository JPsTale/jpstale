package org.jpstale.server.login.api;

/**
 * 选角/删角：对应 C++ AccountServer::SelectCharacter、DeleteCharacter。
 */
public interface CharacterServiceApi {

    /**
     * 选择角色：校验角色归属账号、更新 GM 等级等。
     * TODO: CheckCharacterAccountGouvernance、SQLUpdateGMLevel；当前 stub 返回 true。
     */
    boolean selectCharacter(String accountName, String charName);

    /**
     * 删除角色：校验账号、移文件、SQLDeleteCharacter。
     * TODO: 与 C++ 一致实现；当前 stub 返回 true。
     */
    boolean deleteCharacter(String accountName, String charName);
}
