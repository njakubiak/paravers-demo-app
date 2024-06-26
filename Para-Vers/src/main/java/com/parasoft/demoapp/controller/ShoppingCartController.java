package com.parasoft.demoapp.controller;

import com.parasoft.demoapp.dto.ShoppingCartDTO;
import com.parasoft.demoapp.exception.CartItemNotFoundException;
import com.parasoft.demoapp.exception.ItemNotFoundException;
import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.model.industry.CartItemEntity;
import com.parasoft.demoapp.service.ShoppingCartService;
import com.parasoft.demoapp.util.AuthenticationUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "cart")
@Controller
@RequestMapping({"/v1/cartItems", "/proxy/v1/cartItems"})
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Operation(description = "Add an item to the shopping cart.")
	@Parameters({
		@Parameter(name = "itemId", in = ParameterIn.QUERY, required = true, 
				style = ParameterStyle.FORM, schema = @Schema(type = "integer", format = "int64")),
		@Parameter(name = "itemQty", in = ParameterIn.QUERY, required = true, 
				style = ParameterStyle.FORM, schema = @Schema(type = "integer", format = "int64")),
	})
	@ApiResponses({
		@ApiResponse(responseCode = "200",
				description = "Item added to the shopping cart successfully."),
		@ApiResponse(responseCode = "400",
				description = "Invalid request payload.",
		 		content = {@Content(schema = @Schema(hidden = true))}),
		@ApiResponse(responseCode = "403",
				description = "The user does not have permission to add item to the shopping cart.",
		 		content = {@Content(schema = @Schema(hidden = true)) }),
		@ApiResponse(responseCode = "404",
				description = "This item does not exsit.",
		 		content = {@Content(schema = @Schema(hidden = true)) })
	})
	@PostMapping
	@ResponseBody
	public ResponseResult<CartItemEntity> addItemInCart(
			Authentication auth, @Parameter(hidden = true) @RequestBody ShoppingCartDTO shoppingCartDto)
			throws ItemNotFoundException, ParameterException {

		ResponseResult<CartItemEntity> response = ResponseResult.getInstance(ResponseResult.STATUS_OK,
				ResponseResult.MESSAGE_OK);

		Long currentUserId = AuthenticationUtil.getUserIdInAuthentication(auth);
		response.setData(
				shoppingCartService.addCartItemInShoppingCart(
						currentUserId, shoppingCartDto.getItemId(), shoppingCartDto.getItemQty()));

		return response;
	}
	
	@Operation(description = "Remove an item from the shopping cart.")
	@ApiResponses({
		@ApiResponse(responseCode = "200",
					description = "The item removed from cart successfully."),
		@ApiResponse(responseCode = "403",
					description = "The user does not have permission to remove item from the shopping cart.",
					 content = {@Content(schema = @Schema(hidden = true)) }),
		@ApiResponse(responseCode = "404",
					description = "This cart item does not exsit in the shopping cart.",
		 			 content = {@Content(schema = @Schema(hidden = true)) })
	})
	@DeleteMapping("/{itemId}")
	@ResponseBody
	public ResponseResult<Boolean> removeCartItem(Authentication auth, @PathVariable Long itemId)
			throws CartItemNotFoundException, ParameterException{

		ResponseResult<Boolean> response = ResponseResult.getInstance(ResponseResult.STATUS_OK,
				ResponseResult.MESSAGE_OK);

		Long currentUserId = AuthenticationUtil.getUserIdInAuthentication(auth);
		shoppingCartService.removeCartItemByUserIdAndItemId(currentUserId, itemId);

		return response;		
	}
	
	@Operation(description = "Remove all items under the current user from the shopping cart.")
	@ApiResponses({
		@ApiResponse(responseCode = "200",
				description = "All items under the current user removed from cart successfully."),
		@ApiResponse(responseCode = "403",
				description = "The user does not have permission to remove items from the shopping cart.",
				content = {@Content(schema = @Schema(hidden = true)) }),
		@ApiResponse(responseCode = "404",
				description = "This cart item does not exsit in the shopping cart.",
		 		content = {@Content(schema = @Schema(hidden = true)) })
	})
	@DeleteMapping
	@ResponseBody
	public ResponseResult<Boolean> removeAllCartItems(Authentication auth)
										throws ParameterException, CartItemNotFoundException{

		ResponseResult<Boolean> response = ResponseResult.getInstance(ResponseResult.STATUS_OK,
				ResponseResult.MESSAGE_OK);

		Long currentUserId = AuthenticationUtil.getUserIdInAuthentication(auth);
		shoppingCartService.clearShoppingCart(currentUserId);

		return response;		
	}
	
	@Operation(description = "Update the quantity of item in the shopping cart.")
	@Parameters({
		@Parameter(name = "itemQty", in = ParameterIn.QUERY, required = true, 
				style = ParameterStyle.FORM, schema = @Schema(type = "integer", format = "int64")),})
	@ApiResponses({
		@ApiResponse(responseCode = "200",
				description = "The quantity of item updated in this cart successfully."),
		@ApiResponse(responseCode = "400", description = "Invalid request payload.",
				content = {@Content(schema = @Schema(hidden = true))}),
		@ApiResponse(responseCode = "403",
				description = "The user does not have permission to update the quantity of item in the shopping cart.",
		 		content = {@Content(schema = @Schema(hidden = true)) }),
		@ApiResponse(responseCode = "404",
				description = "This cart item does not exsit in the shopping cart.",
		 content = {@Content(schema = @Schema(hidden = true)) })
	})
	@PutMapping("/{itemId}")
	@ResponseBody
	public ResponseResult<CartItemEntity> updateCartItemQuantity(Authentication auth, @PathVariable Long itemId,
										@Parameter(hidden = true) @RequestBody ShoppingCartDTO shoppingCartDto)
			throws ParameterException, ItemNotFoundException, CartItemNotFoundException {

		ResponseResult<CartItemEntity> response = ResponseResult.getInstance(ResponseResult.STATUS_OK,
				ResponseResult.MESSAGE_OK);

		Long currentUserId = AuthenticationUtil.getUserIdInAuthentication(auth);
		response.setData(shoppingCartService.updateCartItemQuantity(currentUserId,
				                                                    itemId, shoppingCartDto.getItemQty()));

		return response;		
	}

	@Operation(description = "Obtain all items under the current user in the shopping cart.")
	@ApiResponses({
		@ApiResponse(responseCode = "200",
					description = "All items under the current user in the shopping cart got successfully."),
		@ApiResponse(responseCode = "403",
					description = "The user does not have permission to add item to the shopping cart.",
		 content = {@Content(schema = @Schema(hidden = true)) }),
		@ApiResponse(responseCode = "404",
					description = "No cart items under current conditions.",
					content = {@Content(schema = @Schema(hidden = true)) })
	})
	@GetMapping
	@ResponseBody
	public ResponseResult<List<CartItemEntity>> getCartItems(Authentication auth)
			throws ParameterException, CartItemNotFoundException {

		ResponseResult<List<CartItemEntity>> response = ResponseResult.getInstance(ResponseResult.STATUS_OK,
				ResponseResult.MESSAGE_OK);

		Long currentUserId = AuthenticationUtil.getUserIdInAuthentication(auth);
		response.setData(shoppingCartService.getCartItemsByUserId(currentUserId));
		
		return response;		
	}	
	
	@Operation(description = "Obtain an item with item id in the shopping cart.")
	@ApiResponses({
		@ApiResponse(responseCode = "200",
				description = "Item with item id in the shopping cart got successfully."),
	    @ApiResponse(responseCode = "400",
				description = "Invalid request parameter.",
	    			content = {@Content(schema = @Schema(hidden = true))}),
		@ApiResponse(responseCode = "403",
				description = "The user does not have permission to add item to the shopping cart.",
		 content = {@Content(schema = @Schema(hidden = true)) }),
		@ApiResponse(responseCode = "404",
				description = "No cart item under current conditions.",
					content = {@Content(schema = @Schema(hidden = true)) })
	})
	@GetMapping("/{itemId}")
	@ResponseBody
	public ResponseResult<CartItemEntity> getCartItem(Authentication auth, @PathVariable Long itemId)
			throws ParameterException, ItemNotFoundException {

		ResponseResult<CartItemEntity> response = ResponseResult.getInstance(ResponseResult.STATUS_OK,
				ResponseResult.MESSAGE_OK);

		Long currentUserId = AuthenticationUtil.getUserIdInAuthentication(auth);
		response.setData(shoppingCartService.getCartItemByUserIdAndItemId(currentUserId, itemId));

		return response;
	}

}
