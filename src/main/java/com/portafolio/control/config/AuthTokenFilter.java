package com.portafolio.control.config;

//public class AuthTokenFilter extends OncePerRequestFilter {
////    @Autowired
////    private JwtUtils jwtUtils;
////
////    @Autowired
////    private ServicioUsuarioImpl userDetailsService;
////
////    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
////
////    @Override
////    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
////            throws ServletException, IOException {
////        try {
////            String jwt = parseJwt(request);
////            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
////                String username = jwtUtils.getUserNameFromJwtToken(jwt);
////
////                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
////
////                UsernamePasswordAuthenticationToken authentication =
////                        new UsernamePasswordAuthenticationToken(userDetails,
////                                null,
////                                userDetails.getAuthorities());
////
////                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
////
////                SecurityContextHolder.getContext().setAuthentication(authentication);
////            }
////        } catch (Exception e) {
////            logger.error("Cannot set user authentication: {}", e);
////        }
////
////        filterChain.doFilter(request, response);
////    }
////
////    private String parseJwt(HttpServletRequest request) {
////        String jwt = jwtUtils.getJwtFromCookies(request);
////        return jwt;
////    }
//}
