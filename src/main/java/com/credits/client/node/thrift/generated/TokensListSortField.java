/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.node.thrift.generated;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-02-04")
public enum TokensListSortField implements org.apache.thrift.TEnum {
  TL_Code(0),
  TL_Name(1),
  TL_Address(2),
  TL_TotalSupply(3),
  TL_HoldersCount(4),
  TL_TransfersCount(5),
  TL_TransactionsCount(6);

  private final int value;

  private TokensListSortField(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static TokensListSortField findByValue(int value) { 
    switch (value) {
      case 0:
        return TL_Code;
      case 1:
        return TL_Name;
      case 2:
        return TL_Address;
      case 3:
        return TL_TotalSupply;
      case 4:
        return TL_HoldersCount;
      case 5:
        return TL_TransfersCount;
      case 6:
        return TL_TransactionsCount;
      default:
        return null;
    }
  }
}