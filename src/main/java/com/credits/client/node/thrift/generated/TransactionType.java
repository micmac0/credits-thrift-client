/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.client.node.thrift.generated;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-02-04")
public enum TransactionType implements org.apache.thrift.TEnum {
  TT_Normal(0),
  TT_SmartDeploy(1),
  TT_SmartExecute(2),
  TT_SmartState(3);

  private final int value;

  private TransactionType(int value) {
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
  public static TransactionType findByValue(int value) { 
    switch (value) {
      case 0:
        return TT_Normal;
      case 1:
        return TT_SmartDeploy;
      case 2:
        return TT_SmartExecute;
      case 3:
        return TT_SmartState;
      default:
        return null;
    }
  }
}
