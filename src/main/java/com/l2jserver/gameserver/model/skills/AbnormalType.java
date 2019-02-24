/*
 * Copyright © 2004-2019 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.model.skills;

/**
 * Abnormal type enumerate.
 * @author Zoey76
 */
public enum AbnormalType
{
	ABILITY_CHANGE,
	ABNORMAL_INVINCIBILITY,
	ABNORMAL_ITEM,
	AB_HAWK_EYE,
	AGATHION_BUFF,
	ALL_ATTACK_DOWN,
	ALL_ATTACK_UP,
	ALL_REGEN_DOWN,
	ALL_REGEN_UP,
	ALL_SPEED_DOWN,
	ALL_SPEED_UP,
	ANESTHESIA,
	ANTARAS_DEBUFF,
	APELLA,
	ARCHER_SPECIAL,
	ARCHER_SPECIAL_I,
	ARMOR_EARTH,
	ARMOR_ELEMENT_ALL,
	ARMOR_FIRE,
	ARMOR_HOLY,
	ARMOR_UNHOLY,
	ARMOR_WATER,
	ARMOR_WIND,
	ATTACK_SPEED_UP_BOW,
	ATTACK_TIME_DOWN,
	ATTACK_TIME_DOWN_SPECIAL,
	ATTACK_TIME_UP,
	ATTRIBUTE_POTION,
	AVOID_DOWN,
	AVOID_SKILL,
	AVOID_UP,
	AVOID_UP_SPECIAL,
	BERSERKER,
	BETRAYAL_MARK,
	BIG_BODY,
	BIG_HEAD,
	BLEEDING,
	BLESS_THE_BLOOD,
	BLOCK_RESURRECTION,
	BLOCK_SHIELD_UP,
	BLOCK_SPEED_UP,
	BLOCK_TRANSFORM,
	BLOOD_CONSTRACT,
	BOT_PENALTY,
	BOW_RANGE_UP,
	BR_EVENT_BUF1,
	BR_EVENT_BUF10,
	BR_EVENT_BUF2,
	BR_EVENT_BUF3,
	BR_EVENT_BUF4,
	BR_EVENT_BUF5,
	BR_EVENT_BUF6,
	BR_EVENT_BUF7,
	BR_EVENT_BUF8,
	BR_EVENT_BUF9,
	BUFF_QUEEN_OF_CAT,
	BUFF_UNICORN_SERAPHIM,
	CANCEL_PROB_DOWN,
	CASTING_TIME_DOWN,
	CASTING_TIME_UP,
	CHAGNE_ATTR_A,
	CHANGE_ATTR_W,
	CHEAP_MAGIC,
	COMBINATION,
	COUNTER_CRITICAL,
	COUNTER_CRITICAL_TRIGGER,
	COUNTER_SKILL,
	CP_DOWN,
	CP_REGEN_DOWN,
	CP_REGEN_UP,
	CP_UP,
	CRITICAL_DMG_DOWN,
	CRITICAL_DMG_UP,
	CRITICAL_POISON,
	CRITICAL_PROB_DOWN,
	CRITICAL_PROB_UP,
	CURSE_LIFE_FLOW,
	DAMAGE_AMPLIFY,
	DANCE_OF_ALIGNMENT,
	DANCE_OF_AQUA_GUARD,
	DANCE_OF_BERSERKER,
	DANCE_OF_BLADESTORM,
	DANCE_OF_CONCENTRATION,
	DANCE_OF_EARTH_GUARD,
	DANCE_OF_FIRE,
	DANCE_OF_FURY,
	DANCE_OF_INSPIRATION,
	DANCE_OF_LIGHT,
	DANCE_OF_MYSTIC,
	DANCE_OF_PROTECTION,
	DANCE_OF_SHADOW,
	DANCE_OF_SIREN,
	DANCE_OF_VAMPIRE,
	DANCE_OF_WARRIOR,
	DARK_SEED,
	DD_RESIST,
	DEATHWORM,
	DEATH_CLACK,
	DEATH_MARK,
	DEATH_PENALTY,
	DEBUFF_NIGHTSHADE,
	DEBUFF_SHIELD,
	DECREASE_WEIGHT_PENALTY,
	DERANGEMENT,
	DETECT_WEAKNESS,
	DISARM,
	DMG_SHIELD,
	DOT_ATTR,
	DOT_MP,
	DRAGON_BREATH,
	DUELIST_SPIRIT,
	DWARF_ATTACK_BUFF,
	DWARF_DEFENCE_BUFF,
	EARTH_DOT,
	ELEMENTAL_ARMOR,
	ENERGY_OF_TOTEM_1,
	ENERGY_OF_TOTEM_2,
	ENERGY_OF_TOTEM_3,
	ENERGY_OF_TOTEM_4,
	ENERVATION,
	ENTRY_FOR_GAME,
	EVASION_BUFF,
	EVENT_BAWI,
	EVENT_BO,
	EVENT_BUF1,
	EVENT_BUF10,
	EVENT_BUF2,
	EVENT_BUF3,
	EVENT_BUF4,
	EVENT_BUF5,
	EVENT_BUF6,
	EVENT_BUF7,
	EVENT_BUF8,
	EVENT_BUF9,
	EVENT_GAWI,
	EVENT_SANTA_REWARD,
	EVENT_TERRITORY,
	EVENT_WIN,
	EVIL_BLOOD,
	EXPOSE_WEAK_POINT,
	FATAL_POISON,
	FINAL_SECRET,
	FIRE_DOT,
	FISHING_MASTERY_DOWN,
	FLY_AWAY,
	FOCUS_DAGGER,
	FORCE_MEDITATION,
	FORCE_OF_DESTRUCTION,
	FREEZING,
	HEAL_EFFECT_DOWN,
	HEAL_EFFECT_UP,
	HEAL_POWER_UP,
	HERO_BUFF,
	HERO_DEBUFF,
	HIDE,
	HIT_DOWN,
	HIT_UP,
	HOLY_ATTACK,
	HOT_GROUND,
	HP_RECOVER,
	HP_REGEN_DOWN,
	HP_REGEN_UP,
	IMPROVE_CRT_RATE_DMG_UP,
	IMPROVE_HIT_DEFENCE_CRT_RATE_UP,
	IMPROVE_HP_MP_UP,
	IMPROVE_MAGIC_SPEED_CRT_RATE_UP,
	IMPROVE_MA_MD_UP,
	IMPROVE_PA_PD_UP,
	IMPROVE_SHIELD_RATE_DEFENCE_UP,
	IMPROVE_SPEED_AVOID_UP,
	IMPROVE_VAMPIRIC_HASTE,
	INSTINCT,
	INVINCIBILITY,
	IRON_SHIELD,
	IRON_SHIELD_I,
	KAMAEL_SPECIAL,
	KNIGHT_AURA,
	KNIGHT_SHIELD,
	LIFE_FORCE_KAMAEL,
	LIFE_FORCE_ORC,
	LIFE_FORCE_OTHERS,
	LIMIT,
	MAGICAL_STANCE,
	MAGIC_CRITICAL_UP,
	MAJESTY,
	MAX,
	MAXIMUM_ABILITY,
	MAX_BREATH_UP,
	MAX_HP_DOWN,
	MAX_HP_UP,
	MAX_HP_UP_K,
	MAX_MP_UP,
	MA_DOWN,
	MA_MD_UP,
	MA_UP,
	MA_UP_HERB,
	MA_UP_SPECIAL,
	MD_DOWN,
	MD_UP,
	MD_UP_ATTR,
	MENTAL_IMPOVERISH,
	MIGHT_MORTAL,
	MIRAGE,
	MIRAGE_TRAP,
	MORALE_UP,
	MOTION_OF_DEFENCE,
	MP_COST_DOWN,
	MP_COST_UP,
	MP_RECOVER,
	MP_REGEN_UP,
	MP_SHIELD,
	MULTI_BUFF,
	MULTI_BUFF_A,
	MULTI_DEBUFF,
	MULTI_DEBUFF_A,
	MULTI_DEBUFF_B,
	MULTI_DEBUFF_C,
	MULTI_DEBUFF_D,
	MULTI_DEBUFF_E,
	MULTI_DEBUFF_EARTH,
	MULTI_DEBUFF_F,
	MULTI_DEBUFF_FIRE,
	MULTI_DEBUFF_G,
	MULTI_DEBUFF_HOLY,
	MULTI_DEBUFF_SOUL,
	MULTI_DEBUFF_UNHOLY,
	MULTI_DEBUFF_WATER,
	MULTI_DEBUFF_WIND,
	NEVIT_HOURGLASS,
	NONE,
	NORMAL_ATTACK_BLOCK,
	OBLIVION,
	PARALYZE,
	PATIENCE,
	PA_DOWN,
	PA_PD_UP,
	PA_UP,
	PA_UP_HERB,
	PA_UP_SPECIAL,
	PD_DOWN,
	PD_UP,
	PD_UP_BOW,
	PD_UP_SPECIAL,
	PHYSICAL_STANCE,
	PINCH,
	PK_PROTECT,
	POISON,
	POLEARM_ATTACK,
	POSSESSION,
	POSSESSION_SPECIAL,
	POTION_OF_GENESIS,
	PRESERVE_ABNORMAL,
	PROTECTION,
	PUBLIC_SLOT,
	PVP_DMG_DOWN,
	PVP_DMG_UP,
	PVP_WEAPON_BUFF,
	PVP_WEAPON_DEBUFF,
	RAGE_MIGHT,
	REAL_TARGET,
	RECHARGE_UP,
	REDUCE_DROP_PENALTY,
	REFLECT_ABNORMAL,
	REFLECT_MAGIC_DD,
	RESIST_BLEEDING,
	RESIST_DEBUFF_DISPEL,
	RESIST_DERANGEMENT,
	RESIST_HOLY_UNHOLY,
	RESIST_POISON,
	RESIST_SHOCK,
	RESIST_SPIRITLESS,
	RESURRECTION_SPECIAL,
	REUSE_DELAY_DOWN,
	REUSE_DELAY_UP,
	ROOT_MAGICALLY,
	ROOT_PHYSICALLY,
	SEED_BUFF_A,
	SEED_DEBUFF_A,
	SEED_DEBUFF_B,
	SEED_DEBUFF_C,
	SEED_DEBUFF_D,
	SEED_DEBUFF_E,
	SEED_DEBUFF_F,
	SEED_DEBUFF_G,
	SEED_DEBUFF_H,
	SEED_DEBUFF_I,
	SEED_OF_CRITICAL,
	SEED_OF_KNIGHT,
	SEIZURE_A,
	SEIZURE_B,
	SEIZURE_C,
	SEIZURE_PENALTY,
	SHIELD_DEFENCE_UP,
	SHIELD_PROB_UP,
	SIGNAL_A,
	SIGNAL_B,
	SIGNAL_C,
	SIGNAL_D,
	SIGNAL_E,
	SIGNAL_G,
	SILENCE,
	SILENCE_ALL,
	SILENCE_PHYSICAL,
	SKILL_IGNORE,
	SLEEP,
	SNIPE,
	SOA_BUFF1,
	SOA_BUFF2,
	SOA_BUFF3,
	SONG_OF_CHAMPION,
	SONG_OF_EARTH,
	SONG_OF_ELEMENTAL,
	SONG_OF_FLAME_GUARD,
	SONG_OF_HUNTER,
	SONG_OF_INVOCATION,
	SONG_OF_LIFE,
	SONG_OF_MEDITATION,
	SONG_OF_PURIFICATION,
	SONG_OF_RENEWAL,
	SONG_OF_STORM_GUARD,
	SONG_OF_VENGEANCE,
	SONG_OF_VITALITY,
	SONG_OF_WARDING,
	SONG_OF_WATER,
	SONG_OF_WIND,
	SONG_OF_WINDSTORM,
	SPA_DISEASE_A,
	SPA_DISEASE_B,
	SPA_DISEASE_C,
	SPA_DISEASE_D,
	SPEED_DOWN,
	SPEED_UP,
	SPEED_UP_SPECIAL,
	SPITE,
	SPOIL_BOMB,
	SSQ_TOWN_BLESSING,
	SSQ_TOWN_CURSE,
	STEALTH,
	STIGMA_A,
	STIGMA_OF_SILEN,
	STUN,
	SUB_TRIGGER_CRT_RATE_UP,
	SUB_TRIGGER_DEFENCE,
	SUB_TRIGGER_HASTE,
	SUB_TRIGGER_SPIRIT,
	SUMMON_CONDITION,
	TALISMAN,
	TARGET_LOCK,
	THIN_SKIN,
	THRILL_FIGHT,
	TIME_BOMB,
	TIME_CHECK,
	TOUCH_OF_DEATH,
	TOUCH_OF_LIFE,
	TRANSFER_DAMAGE,
	TRANSFORM,
	TRANSFORM_HANGOVER,
	TRANSFORM_SCRIFICE,
	TRANSFORM_SCRIFICE_P,
	TURN_FLEE,
	TURN_PASSIVE,
	TURN_STONE,
	T_CRT_DMG_DOWN,
	T_CRT_DMG_UP,
	T_CRT_RATE_DOWN,
	T_CRT_RATE_UP,
	ULTIMATE_BUFF,
	ULTIMATE_DEBUFF,
	VALAKAS_ITEM,
	VAMPIRIC_ATTACK,
	VAMPIRIC_ATTACK_SPECIAL,
	VIBRATION,
	VOTE,
	VP_CHANGE,
	VP_KEEP,
	VP_UP,
	WATCHER_GAZE,
	WATER_DOT,
	WEAK_CONSTITUTION,
	WEAPON_MASTERY,
	WILL,
	WIND_DOT,
	WISPERING_OF_BATTLE,
	WP_CHANGE_EVENT;
	
	/**
	 * Verify if this enumerate is default.
	 * @return {@code true} if this enumerate is none, {@code false} otherwise
	 */
	public boolean isNone()
	{
		return this == NONE;
	}
}
