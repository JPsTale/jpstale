# Formula List

## Damage Formula

* Base Damage without weapon = 1-2
* Base Damage with weapon = 1-3
* Every 130 agility (add 130 extra agility) = 100% weapon damage boost (Archer/Atalanta wearing Bow/Javelin)
* Every 190 agility (add 190 extra agility) = 100% weapons damage boost (other classes wearing range weapons)
* Every 130 strength (add 130 extra strength) = 100% weapon damage boost (Fighter/Pikeman/Assassin/Knight/Brawler wearing melee weapons )
* Every 150 strength (add 150 extra strength) = 100% weapon damage boost (Mechanician/Atalanta wearing melee weapons)
* Every 190 strength (add 190 extra strength) = 100% weapon damage boost (Archer/Priestess/Magician/Shaman wearing melee weapons)
* Every 150 spirit (add 150 extra spirit) = 100% weapon damage boost (Magician/Shaman wearing Staff/Wand)
* Every 170 spirit (add 170 extra spirit) = 100% weapon damage boost (Priestess wearing Staff/Wand)

If Fighter/Pikeman/Assassin/Knight/Brawler and not wearing a weapon:

* +1 damage 
* every 130 str = +1 damage
* every 40 of (talent+agility) = +1 min damage
* every 35 of (talent+agility) = +1 max damage

If other class and not wearing a weapon:

* +1 damage
* every 200 str = +1 damage
* every 50 of (talent+agility) = +1 min damage
* every 45 of (talent+agility) = +1 max damage

If Fighter/Pikeman/Assassin/Knight/Brawler and wearing melee weapon:

* every 40 (talent+agility) = +1 damage 

If Mechanician/Atalanta and wearing melee weapon:

* every 45 (talent+agility) = +1 damage

If Archer/Priestess/Magician/Shaman and wearing melee weapon:

* every 50 (talent+agility) = +1 damage

If Archer/Atalanta and wearing range weapon (Bow/Javalin):

* every 40 (talent+strength) = +1 damage

If other class and wearing range weapon (Bow/Javelin):

* every 50 (talent+strength) = +1 damage

If Magician/Shaman/Priestess and wearing Staff/Wand:

* every 30 talent = +1 damage

Additional Damage = 1-1


WEAPON = 100% of damage of weapon

* Bonus. (attack power displayed in yellow) = (if : Mechanician uses a Mechanician-specced Weapon - Atalanta uses a Javelin - Knight use a Sword - Pikeman use a Scythe - Fighter uses an Axe - Priestess or Magician uses a Wand/Staff - Archer uses a Bow - Assassin uses two Daggers - Shaman uses a Phantom - Brawler uses a Fist) => (then : add lvl/6 damage to min&max)
* Spec. weapon lvl/x => +0min +(lvl/x) max
* (min weapon + max weapon)/16 => add to your min damage

## Critical Damage Boost Formula

PvE

All Classes: 70%

PvP

All Classes: 70%

## Absorb Formula

All classes

* For each item with abs equipped you get +0.5 abs extra on top of the abs of that item
* 100 def = 1 abs
* 40 strength = 1 abs
* 40 spirit = 1 abs
* 40 talent = 1 abs (and 40 talent = 10def = +0.1 abs) = 1.1 abs
* 40 agility = 0 abs (and 40 agility = 40def = +0.4 abs) = 0.4 abs
* 40 health = 1 abs
* 10 lvl = 1 abs (and 10 lvl = 14def = +0.14 abs) = 1.14 abs
* 1 abs point extra = 1 abs

Note: If you have 7.124 abs you will get 7 abs

Note: The final received damage is subtracted with your abs

## Attack Rating Formula

All classes

`(LV * 2.6) + (STR * 0.8) + (SPI * 0.8) + (TAL * 1.2) + (AGI * 1.9)`

## Defense Rating Formula

All classes

`(LV * 1.0) + (STR * 0.3) + (SPI * 0.3) + (TAL * 1.2) + (AGI * 0.4)`

## Running Speed Formula

All classes

`0.4 + health/200 + talent/100 + level/200 + boots speed - (current weight / limit weight (so full weight = -1))`

* Minimum: 1
* Maximum: 51

## Health Points (HP) Formula

Fighter, Mechanician

`( LV * 2.1 ) + ( STR * 0.8 ) + ( HEA * 2.4 )`

Pikeman, Knight, Atalanta

`( LV * 2.1 ) + ( STR * 0.6 ) + ( HEA * 2.2 )`

Archer

`( LV * 1.8 ) + ( STR * 0.4 ) + ( HEA* 2.6 )`

Priestess

`( LV * 2.8 ) + ( STR * 2.8 )`

Magician

`( LV * 1.8 ) + ( STR * 2.0 )`

Assassin

`( LV * 2.1 ) + ( STR * 0.7 ) + ( HEA * 2.1 )`

Shaman

`( LV * 2.1 ) + ( STR * 0.6 ) + ( HEA * 1.8 )`

Brawler

`( LV * 1.9 ) + ( STR * 0.8 ) + ( TAL* 0.1 ) + ( HEA * 2.6 )`

## Mana Points (MP) Formula

Fighter, Pikeman, Archer, Assassin, Brawler

`( LV * 0.6 ) + ( SPI * 2.2 )`

Mechanician, Knight, Atalanta

`( LV * 0.9 ) + ( SPI * 2.7 )`

Priestess, Magician, Shaman

`( LV * 1.5 ) + ( SPI * 3.8 )`

## Stamina Points (SP) Formula

All classes

`( LV * 2.3 ) + ( STR * 0.5 ) + ( SPI * 1.0 ) + ( TAL * 0.5 ) + ( HEA * 1.4 ) + 80`

## Weight Formula

All classes

`(LV * 5.0) + (STR * 1.6) + (SPI * 1.0) + (TAL * 1.0) + (AGI * 1.0) + (HEA * 1.5) + 60`