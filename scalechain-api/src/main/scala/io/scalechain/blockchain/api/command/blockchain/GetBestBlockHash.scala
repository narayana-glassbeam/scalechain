package io.scalechain.blockchain.api.command.blockchain

import io.scalechain.blockchain.api.command.RpcCommand
import io.scalechain.blockchain.api.domain.{RpcRequest, RpcResult}

/*
  CLI command :
    bitcoin-cli -testnet getbestblockhash

  CLI output :
    0000000000075c58ed39c3e50f99b32183d090aefa0cf8c324a82eea9b01a887

  Json-RPC request :
    {"jsonrpc": "1.0", "id":"curltest", "method": "getbestblockhash", "params": [] }

  Json-RPC response :
    {
      "result": << Same to CLI Output >> ,
      "error": null,
      "id": "curltest"
    }

*/

/** GetBestBlockHash: returns the header hash of the most recent block on the best block chain.
  *
  * Since - New in 0.9.0
  *
  * https://bitcoin.org/en/developer-reference#getbestblockhash
  */
object GetBestBlockHash extends RpcCommand {
  def invoke(request : RpcRequest ) : RpcResult = {
    // TODO : Implement
    assert(false)
    null
  }
}

